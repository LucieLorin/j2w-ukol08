package cz.czechitas.java2webapps.ukol8.Service;

import cz.czechitas.java2webapps.ukol8.PostRepository.PostRepository;
import cz.czechitas.java2webapps.ukol8.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class PostService {
 private final PostRepository postRepository;

 @Autowired
 public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<Post> list (Pageable pageable) {
    return  postRepository.findAll(pageable);
    }

    public Page <Post> singlePost(String slug, Pageable pageable) {
     return postRepository.findBySlug(slug, pageable);
    }

//    public Page <Post> findAllByPublishedBefore(LocalDate localDate, Pageable pageable) {
//     return postRepository.findAllByPublishedBefore(localDate, pageable);
//    }
}

// Entity|Bean <--> Controller(Service) <--> Service(Repo) <--> Repo(Database) <--> Database
