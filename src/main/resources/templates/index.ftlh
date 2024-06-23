[#ftl]
[#import '_imports/common.ftlh' as c]

[#-- Proč ve cvičeních v hodině tento řádek není potřeba, ale teď v mém úkolu ano? --]

[@c.page]
        <div>
            [#list posts as post]
                <div class="context">
                    <h2>${post.title}</h2>
                    <h3>Autor: ${post.author}</h3>
                    ${post.perex?no_esc}
                </div>
            <a href="/${post.slug}">Celý článek</a>
            [/#list]
        </div>
    [/@c.page]