package com.sypialnia.domain.repositories;

import com.sypialnia.domain.entities.Image;
import com.sypialnia.domain.entities.ImageId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, ImageId> {}
