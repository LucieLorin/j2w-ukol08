package cz.czechitas.java2webapps.ukol8.Controller;

import cz.czechitas.java2webapps.ukol8.Service.PostService;
import cz.czechitas.java2webapps.ukol8.entity.Post;
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
    public ModelAndView firstPage(Pageable pageable) {
        return new ModelAndView("index")
                .addObject("post", postService.list(pageable));

    }

    @GetMapping(path = "/detail/{slug}")
    public ModelAndView detail(@PathVariable String slug, Pageable pageable) {
        return new ModelAndView("detail")
                .addObject("post", postService.singlePost(slug, pageable));
    }
}
