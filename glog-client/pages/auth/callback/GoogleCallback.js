import SocialCallback from '../../../components/auth/SocialCallback';

function GithubCallback() {
    const authURI = `${process.env.googleAuthURI}`;
    return (
        <SocialCallback
            authURI={authURI}
            nowURL={typeof window !== 'undefined' ? window.location.href : ''}
        />
    );
}

export default GithubCallback;
