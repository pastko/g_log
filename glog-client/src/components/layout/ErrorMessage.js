import { useState } from 'react';
import styled from 'styled-components';

function ErrorMessage({ isForm, type }) {
    const [msg, setMsg] = useState({
        mailMsg: '',
        pwdMsg: '',
        confirmPwdMsg: '',
    });

    const validate = (isForm) => {
        const mailRegex = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+$/;
        const pwdRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,12}$/;

        if (!mailRegex.test(isForm.mail)) {
            setMsg(...msg, {
                mailMsg: '이메일 형식이 아닙니다.',
            });
        } else if (!pwdRegex.test(isForm.pwd)) {
            setMsg(...msg, {
                pwdlMsg:
                    '비밀번호는 최소8자 및 최대 12자, 영문/숫자/특수문자 조합이어야 합니다.',
            });
        } else if (isForm.pwd !== isForm.confirmPwd) {
            setMsg(...msg, {
                confirmPwd: '비밀번호가 일치해야합니다.',
            });
        }
    };

    if (validate(isForm)) {
        if (type === 'mail') return <div> {msg.mailMsg} </div>;
        if (type === 'pwd') return <div> {msg.pwdMsg} </div>;
        if (type === 'pwdConfirm') return <div> {msg.confirmPwdMsg} </div>;
    } else {
        return <> </>;
    }
}
const StyledErrorMsg = styled.div`
    text-align: right;
    font-size: 0.8rem;
    color: #d81d1d;
`;
export default ErrorMessage;
