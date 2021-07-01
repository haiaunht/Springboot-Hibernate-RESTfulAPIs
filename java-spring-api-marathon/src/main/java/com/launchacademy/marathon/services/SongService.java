package com.launchacademy.marathon.services;

import com.launchacademy.marathon.models.Song;
import com.launchacademy.marathon.repositories.SongRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService {
  private SongRepository songRepository;

  @Autowired
  public SongService(SongRepository songRepository) {
    this.songRepository = songRepository;
  }

  public List<Song> findAllSongs() {
    return (List<Song>) songRepository.findAll();
  }

  public void add(Song party) {
    this.songRepository.save(party);
  }

}
