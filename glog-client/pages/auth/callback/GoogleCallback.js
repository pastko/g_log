import SocialCallback from '../../../components/auth/SocialCallback';

function GithubCallback() {
    const nowURL = new URL(window.location.href);
    const authURI = `${process.env.GOOGLE_AUTH_URI}`;
    return <SocialCallback authURI={authURI} nowURL={nowURL} />;
}

export default GithubCallback;
