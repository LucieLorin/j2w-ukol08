package cz.czechitas.java2webapps.ukol8.Service;

import cz.czechitas.java2webapps.ukol8.PostRepository.PostRepository;
import cz.czechitas.java2webapps.ukol8.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PostService {
 private final PostRepository postRepository;

 @Autowired
 public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<Post> list() {
        Pageable pageable = PageRequest.of(0, 20);
    return  postRepository.findAll(pageable);
    }

    public Object singlePost(String slug) {
     return postRepository.findBySlug(slug);
    }

}

// Entity|Bean <--> Controller(Service) <--> Service(Repo) <--> Repo(Database) <--> Database