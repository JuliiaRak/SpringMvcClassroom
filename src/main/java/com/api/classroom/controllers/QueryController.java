package com.api.classroom.controllers;

import com.api.classroom.domain.Message;
import com.api.classroom.domain.Query;
import com.api.classroom.domain.User;
import com.api.classroom.repos.MessageRepo;
import com.api.classroom.repos.QueryRepo;
import com.api.classroom.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class QueryController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private QueryRepo queryRepo;


    @GetMapping("/query")
    public String getQuery(@RequestParam(required = false, defaultValue = "") String filter, Model model){
        Iterable<Query> members = queryRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            members = queryRepo.findByAdmin(filter);
        } else {
            members = queryRepo.findAll();
        }

        model.addAttribute("members", members);
        model.addAttribute("filter", filter);
        return "query";
    }

    @PostMapping("/query")
    public String addQuery(
            @AuthenticationPrincipal User user,
            @RequestParam String comment,
            @RequestParam String admin,
            Map<String, Object> model
    ) throws IOException {
        Query member = new Query(comment, false, user, admin);

        queryRepo.save(member);
        Iterable<Query> members = queryRepo.findAll();
        model.put("members", members);
        return "query";
    }

}
