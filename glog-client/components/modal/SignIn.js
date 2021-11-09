import React from 'react';
import AuthTemplate from '../auth/AuthTemplate';
import AuthForm from '../auth/AuthForm';
import styled from 'styled-components';

const goSignIn = (form) => {
    const { mail, pwd, confirmPwd, nikNm } = form;
    axios
        .post('https://localhost:8080/signin', {
            mail: mail,
            pwd: pwd,
        })
        .then((res) => {
            console.log(res);
        })
        .catch((error) => {
            console.log(error);
            throw new Error(error);
        });
};

const SignIn = ({ setIsOpen }) => {
    return (
        <AuthTemplate setIsOpen={setIsOpen}>
            <AuthForm func={goSignIn} />{' '}
        </AuthTemplate>
    );
};

export default SignIn;
