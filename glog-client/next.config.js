/** @type {import('next').NextConfig} */
module.exports = {
  reactStrictMode: true,
  env: {
    googleClientId: process.env.GOOGLE_CLIENT_ID,
    googleRedirectURI: process.env.GOOGLE_REDIRECT_URI,
    githubClientId: process.env.GITHUB_CLIENT_ID,
    githubRedirectURI: process.env.GITHUB_REDIRECT_URI,
    githubAuthURI: process.env.GITHUB_AUTH_URI,
    sResource: process.env.S_RESOURCE,
  }
}