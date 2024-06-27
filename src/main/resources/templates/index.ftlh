[#ftl]

[#-- Proč ve cvičeních v hodině tento řádek není potřeba, ale teď v mém úkolu ano? --]

[@c.page]
    <div>
        [#list posts.content as post]
        [#-- "posts.content as post" používám, protože používám Page<Post>. Kdybych použila List<Post>, tak stačí "posts as post. --]
            <div class="context">
                <h2>${post.title}</h2>
                <span><h3>${post.author}</h3> ${post.published?date}</span>
                ${post.perex?no_esc}
            </div>
            <a href="/${post.slug}">Celý článek</a>
            <hr>
        [/#list]


    </div> [@c.pager /]
[/@c.page]