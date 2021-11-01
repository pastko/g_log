import React from 'react';
import AuthTemplate from '../../components/auth/AuthTemplate';
import AuthForm from '../../components/auth/AuthForm';

const goSignIn = (form) => {
    const {mail, pwd, confirmPwd, nikNm} = form;
    axios.post('https://localhost:8080/signin', {
        mail: mail,
        pwd: pwd
    }).then(res => {
        console.log(res);
    }).catch(error => {
        console.log(error);
        throw new Error(error);
    });
}

const SignIn = () => {
    return (
        <AuthTemplate>
            <AuthForm func={goSignIn}/>
        </AuthTemplate>
    );
};

export default SignIn;
