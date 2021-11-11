/** @type {import('next').NextConfig} */
module.exports = {
  reactStrictMode: true,
  env: {
    googleClientId: process.env.GOOGLE_CLIENT_ID,
    googleRedirectURI: process.env.GOOGLE_REDIRECT_URI,
    googleAuthURI: process.env.GOOGLE_AUTH_URI,
    githubClientId: process.env.GITHUB_CLIENT_ID,
    githubRedirectURI: process.env.GITHUB_REDIRECT_URI,
    githubAuthURI: process.env.GITHUB_AUTH_URI,
    mailRegex: process.env.EMAIL_REGEX,
    pwdRegex: process.env.PASSWORD_REGEX,
    s3URL : process.env.S3_URL,
    S3UPLOADBUCKET : process.env.S3_UPLOAD_BUCKET,
    S3UPLOADREGION : process.env.S3_UPLOAD_REGION,
    S3UPLOADKEY : process.env.S3_UPLOAD_KEY,
    S3UPLOADSECRET: process.env.S3_UPLOAD_SECRET,
  },
  images: {
    domains: [
      `${process.env.S3_UPLOAD_BUCKET}.s3.amazonaws.com`,
      `${process.env.S3_UPLOAD_BUCKET}.s3.${process.env.S3_UPLOAD_REGION}.amazonaws.com`,
    ],
  }
}