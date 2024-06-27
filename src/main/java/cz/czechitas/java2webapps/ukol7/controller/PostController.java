package cz.czechitas.java2webapps.ukol7.controller;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import cz.czechitas.java2webapps.ukol7.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("")
    public ModelAndView newestPosts(@PageableDefault() Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("index");
        pageable = PageRequest.of(0, 5);
        Page<Post> posts = postService.getPostsOrderByPublished(pageable);
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    @GetMapping("/{slug}")
    public ModelAndView detail(@PathVariable String slug) {
        ModelAndView modelAndView = new ModelAndView("article");
        modelAndView.addObject("post", postService.singlePost(slug));
        return modelAndView;
    }
}
/*
12) Uprav metodu list() v PostService tak, aby používala Pageable
    a omezila výsledek na 20 záznamů. Pro vytvoření správného Pageable
    použij statickou metodu PageRequest.of(0, 20). Vytvoř v repository
    metodu, která bude vracet Page, bude používat Pageable pro omezení
    počtu záznamů, načte pouze posty, které mají datum publikace a není
    v budoucnosti, a seřadí záznamy sestupně podle data publikace.
    Pro řazení se nebude používat položka sort z Pageable ( to se používá
    v případě, kdy má uživoatel mít možnost měnit způsob řazení – my ale
    chceme zápisky seřadit vždy od nejnovějšího po nejstarší).
    Místo toho se použije správný název metody v repository
    (součástí názvu metody bude tedy text OrderBy).

13) Bonus: Můžeš upravit šablonu pro výpis seznamu zápisků tak,
    aby bylo možné stránkami listovat. Nepoužije se ale číslování stránek,
    místo toho budou dole na stránce jen odkazy „předchozí“ a „další“.
    Použij k tomu metody hasPrevious() a hasNext() na rozhraní Page.
 */