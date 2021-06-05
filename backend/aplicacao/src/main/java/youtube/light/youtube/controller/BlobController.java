// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package youtube.light.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import youtube.light.youtube.service.BlobService;

import java.io.IOException;

@RestController
@RequestMapping("blob")
public class BlobController {

    @Autowired
    private BlobService blobService;

    @PostMapping
    public String uploadBlobFile(@RequestParam("file") MultipartFile file) throws IOException {
        blobService.storeFile(file.getOriginalFilename(), file.getInputStream(), file.getSize());
        return "Arquivo foi atualizado";
    }
}