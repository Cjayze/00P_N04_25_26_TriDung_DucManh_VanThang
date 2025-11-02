package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Device;
import com.example.servingwebcontent.model.Room;
import com.example.servingwebcontent.repository.DeviceRepository;
import com.example.servingwebcontent.repository.RoomRepository;
import com.example.servingwebcontent.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final RoomRepository roomRepository;
    private final RoomService roomService;
    private final DeviceRepository deviceRepository;

    public RoomController(RoomRepository roomRepository, RoomService roomService, DeviceRepository deviceRepository) {
        this.roomRepository = roomRepository;
        this.roomService = roomService;
        this.deviceRepository = deviceRepository;
    }

    // 🏠 Hiển thị danh sách tất cả Sản phẩm
    @GetMapping("/all")
    public String listRooms(Model model) {
        try {
            model.addAttribute("rooms", roomRepository.findAll());
            return "room_list";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Không thể tải danh sách Sản phẩm: " + e.getMessage());
            return "error";
        }
    }

    // ➕ Hiển thị form thêm mới Sản phẩm
    @GetMapping("/new")
    public String showAddForm(Model model) {
        try {
            model.addAttribute("room", new Room());
            return "room_form";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Không thể hiển thị form thêm Sản phẩm: " + e.getMessage());
            return "error";
        }
    }

    // 💾 Lưu thông tin Sản phẩm (thêm/sửa) + upload ảnh
    @PostMapping("/save")
    public String saveRoom(@ModelAttribute Room room,
            @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
            Model model) {
        try {
            // Xử lý upload ảnh nếu có
            if (imageFile != null && !imageFile.isEmpty()) {
                String uploadDir = "src/main/resources/static/uploads/";
                File directory = new File(uploadDir);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
                Path filePath = Paths.get(uploadDir, fileName);

                Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                room.setImageUrl("/uploads/" + fileName);
            }

            // Lưu vào DB
            roomRepository.save(room);
            return "redirect:/rooms/all";

        } catch (IOException e) {
            model.addAttribute("errorMessage", "Lỗi khi tải ảnh: " + e.getMessage());
            return "error";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Lỗi khi lưu Sản phẩm: " + e.getMessage());
            return "error";
        }
    }

    // ✏️ Hiển thị form sửa Sản phẩm theo ID
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        try {
            Room room = roomRepository.findById(id).orElse(null);
            if (room == null) {
                model.addAttribute("errorMessage", "Không tìm thấy Sản phẩm với ID: " + id);
                return "error";
            }
            model.addAttribute("room", room);
            return "room_form";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Lỗi khi tải thông tin Sản phẩm: " + e.getMessage());
            return "error";
        }
    }

    // ❌ Xoá Sản phẩm theo ID
    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable("id") Integer id, Model model) {
        try {
            roomRepository.deleteById(id);
            return "redirect:/rooms/all";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Lỗi khi xoá Sản phẩm: " + e.getMessage());
            return "error";
        }
    }

    // ⏰ Hiển thị danh sách Sản phẩm
    @GetMapping("/due")
    public String showRoomsDueSoon(Model model) {
        try {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime in7Days = now.plusDays(7);
            List<Room> dueRooms = roomRepository.findByDueDateBetweenAndStatus(now, in7Days, Room.Status.occupied);
            model.addAttribute("dueRooms", dueRooms);
            return "room_due_list";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Lỗi khi tải danh sách Sản phẩm đến hạn: " + e.getMessage());
            return "error";
        }
    }

    // 👁️ Xem chi tiết Sản phẩm
    @GetMapping("/view/{id}")
    public String viewRoomDetails(@PathVariable Integer id, Model model) {
        Room room = roomService.getRoomById(id);
        if (room == null) {
            model.addAttribute("errorMessage", "Không tìm thấy Sản phẩm với ID: " + id);
            return "error";
        }
        List<Device> devices = deviceRepository.findByRoomId(id);
        model.addAttribute("room", room);
        model.addAttribute("devices", devices);
        return "room_detail";
    }

    // 🔍 Tìm sản phẩm
    @GetMapping("/search")
    public String searchRooms(@RequestParam(required = false) String keyword,
            @RequestParam(required = false) Room.Status status,
            Model model) {
        try {
            List<Room> rooms;

            if ((keyword == null || keyword.isEmpty()) && status == null) {
                rooms = roomRepository.findAll();
            } else if (keyword != null && !keyword.isEmpty() && status != null) {
                rooms = roomRepository.findByRoomNumberContainingIgnoreCaseAndStatus(keyword, status);
            } else if (keyword != null && !keyword.isEmpty()) {
                rooms = roomRepository.findByRoomNumberContainingIgnoreCase(keyword);
            } else {
                rooms = roomRepository.findByStatus(status);
            }

            model.addAttribute("rooms", rooms);
            return "room_list";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Lỗi khi tìm kiếm sản phẩm: " + e.getMessage());
            return "error";
        }
    }
}
