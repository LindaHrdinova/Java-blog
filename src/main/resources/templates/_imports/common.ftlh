[#ftl]

[#macro page title="Můj blog"]
    <!DOCTYPE html>
    <html lang="cs">
    <head>
        <meta charset="UTF-8">
        <title>${title}</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="/images/favicon.png">
        <link rel="stylesheet" href="/css/style.css">
    </head>
    <body>
    <div class="blog">
        <header><h1>Vítejte na blogu!</h1></header>
        [#nested]
        <footer>Linda Hrdinová - Czechitas Java 2</footer>
    </div>
    </body>
    </html>
[/#macro]

[#macro pager]
    <div class="pager">
        [@pagerLink page=posts.number - 1 active=posts.first text="předchozí" /]
        [@pagerLink page=posts.number + 1 active=posts.last text="další" /]
    </div>
[/#macro]

[#macro pagerLink page text active]
    [#if active]
        <span class="page active">${text}</span>
    [#else ]
        <a href="${createURL({"size": 5, "page": page})}" class="page">${text}</a>
    [/#if]
[/#macro]
