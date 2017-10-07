package com.demianchuk.service.post;

import com.demianchuk.models.Post;
import com.demianchuk.service.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FilterPostService {
    List<Post> filter(int page, int size);
}

@Service
class FilterPostServiceImpl implements FilterPostService     {

    @Autowired
    private PostRepository postRepository;

    public List<Post> filter(int page, int size){
        return postRepository.findAll(
                new PageRequest(
                        page,
                        size,
                        new Sort(new Sort.Order(Sort.Direction.ASC,"createdAt")))).getContent();
    }
}
