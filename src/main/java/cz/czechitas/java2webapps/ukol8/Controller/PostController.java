package cz.czechitas.java2webapps.ukol8.Controller;

import cz.czechitas.java2webapps.ukol8.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public ModelAndView index(Pageable pageable) {
        return new ModelAndView("index")
                .addObject("post", postService.list());

    }

    @GetMapping(path = "/post/{slug}")
    public ModelAndView detail(@PathVariable String slug) {
        return new ModelAndView ("detail")
                .addObject("post", postService.singlePost(slug));
    }
}
