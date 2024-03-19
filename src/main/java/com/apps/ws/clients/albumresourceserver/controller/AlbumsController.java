package com.apps.ws.clients.albumresourceserver.controller;

import com.apps.ws.clients.albumresourceserver.responce.AlbumRest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

  @GetMapping
  public List<AlbumRest> getAlbums() {
    var album1 = AlbumRest.builder()
            .albumId("albumIdHere")
            .userId("1")
            .albumTitle("Album 1 title")
            .albumDescription("Album 1 description")
            .albumUrl("Album 1 URL")
            .build();
    var album2 = AlbumRest.builder()
            .albumId("albumIdHere")
            .userId("2")
            .albumTitle("Album 2 title")
            .albumDescription("Album 2 description")
            .albumUrl("Album 2 URL")
            .build();

    return Arrays.asList(album1, album2);
  }

}