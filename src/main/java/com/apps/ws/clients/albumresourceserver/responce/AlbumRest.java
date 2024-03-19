package com.apps.ws.clients.albumresourceserver.responce;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlbumRest {
  private String userId;
  private String albumId;
  private String albumTitle;
  private String albumDescription;
  private String albumUrl;
}