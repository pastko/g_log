import { useEffect, useState } from 'react';
import qs from 'qs';
import axios from 'axios';
import Header from '../common/Header';
import AuthForm from './AuthForm';

function SocialCallback({ authURI, nowURL }) {
    const [isState, setState] = useState({
        isLogin: false,
        accessToken: '',
    });

    const { isLogin, accessToken } = isState;

    useEffect(() => {
        const getToken = async () => {
            const authorizationCode = nowURL.searchParams.get('code');
            // const { code } = qs.parse(location.search, {
            //     ignoreQueryPrefix: true,
            // });

            const response = axios
                .post(`${authURI}`, {
                    authorizationCode: `${authorizationCode}`,
                })
                .then((res) => {
                    console.log(res);
                    setState({
                        isLogin: true,
                        accessToken: response.data.accessToken,
                    });
                })
                .catch((error) => {
                    console.log(error);
                });
        };
        getToken();
    }, [nowURL, authURI]);

    return (
        <>
            {' '}
            {isLogin ? (
                <Header accessToken={accessToken} />
            ) : (
                <AuthForm isLoginFailed />
            )}{' '}
        </>
    );
}

export default SocialCallback;
