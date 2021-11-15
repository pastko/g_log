const {
    createProxyMiddleware
} = require('http-proxy-middleware')


module.exports = function (app) {
    app.use(
        createProxyMiddleware('/signin', {
            target: 'http://localhost:8080',
            changeOrigin: true
        })
    )
    app.use(
        createProxyMiddleware('/signout', {
            target: 'http://localhost:8080',
            changeOrigin: true
        })
    )
    app.use(
        createProxyMiddleware('/signup', {
            target: 'http://localhost:8080',
            changeOrigin: true
        })
    )
    app.use(
        createProxyMiddleware('/board', {
            target: 'http://localhost:8080',
            changeOrigin: true
        })
    )
    app.use(
        createProxyMiddleware('/myinfo', {
            target: 'http://localhost:8080',
            changeOrigin: true
        })
    )

}