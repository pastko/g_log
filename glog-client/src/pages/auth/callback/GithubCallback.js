import SocialCallback from '../../../components/auth/SocialCallback';

function GithubCallback() {
    const authURI = `${process.env.GITHUB_AUTH_URI}`;
    return <SocialCallback authURI={authURI} nowURL={(typeof window !== 'undefined') ? window.location.href : ''} />;
}

export default GithubCallback;
