[#ftl]
[#import '_imports/common.ftlh' as c]

[@c.page title="${post.title}"]
    <h2>${post.title}</h2>
    <span><h3>${post.author}</h3> ${post.published?date}</span>
    ${post.perex?no_esc}
    ${post.body?no_esc}
    <a href="/">zpátky</a>
[/@c.page]