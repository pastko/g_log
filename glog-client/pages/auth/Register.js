import React from 'react';
import AuthTemplate from '../../components/auth/AuthTemplate';
import AuthForm from '../../components/auth/AuthForm';
import axios from 'axios';

const goRegister = (form) => {
    const {mail, pwd, confirmPwd, nikNm} = form;
    axios.post('https://localhost:8080/signup', {
        mail: mail,
        pwd: pwd,
        nikNm: nikNm
    }).then(res => {
        console.log(res);
    }).catch(error => {
        console.log(error);
        throw new Error(error);
    });
}

const Register = ({setIsOpen}) => {
    return (
        <AuthTemplate setIsOpen={setIsOpen}>
            <AuthForm isRegister func={goRegister} />
        </AuthTemplate>
    );
}

export default Register;