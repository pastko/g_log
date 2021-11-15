// const {
//     createProxyMiddleware
// } = require('http-proxy-middleware')


// module.exports = function (app) {
//     app.use(
//         createProxyMiddleware('/signin', {
//             target: process.env.REACT_APP_SERVER_URL,
//             changeOrigin: true
//         })
//     )
//     app.use(
//         createProxyMiddleware('/signout', {
//             target: process.env.REACT_APP_SERVER_URL,
//             changeOrigin: true
//         })
//     )
//     app.use(
//         createProxyMiddleware('/signup', {
//             target: process.env.REACT_APP_SERVER_URL,
//             changeOrigin: true
//         })
//     )
//     app.use(
//         createProxyMiddleware('/board', {
//             target: process.env.REACT_APP_SERVER_URL,
//             changeOrigin: true
//         })
//     )
//     app.use(
//         createProxyMiddleware('/myinfo', {
//             target: process.env.REACT_APP_SERVER_URL,
//             changeOrigin: true
//         })
//     )

// }