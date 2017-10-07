package com.demianchuk.service.repositories;

import com.demianchuk.service.records.UserPostLike;
import org.springframework.data.repository.CrudRepository;

public interface UserPostLikeRepository extends CrudRepository<UserPostLike, String> {

    UserPostLike getByUserAndPostId(String user, long postId);
}
