import { useState } from "react";
import styled, { css } from "styled-components";
//import ErrorMessage from '../layout/ErrorMessage';

function AuthButton({ isLink, defaultType, fullWidth, goAction, ...rest }) {
  console.log("AuthButton");
  const { isDisabled, setIsDisabled } = useState(false);

  // const validate = () => {
  //     if (!isForm.mail || !isForm.pwd || !isForm.confirmPwd) {
  //         setIsDisabled(false);
  //     } else {
  //         if (isForm.nikNm === '') {
  //             let tmpStr = userInfo.email.split('@');
  //             let id = tmpStr[0];
  //             userInfo.nickname = id;
  //         }
  //         setIsDisabled(true);
  //     }
  // };
  //TODO ::// ==>>
  if (isLink) {
    return <LinkStyled defaultType={defaultType} {...rest} />;
  }

  // if (validate()) {
  if (goAction) {
    return (
      <ButtonStyled
        fullWidth={fullWidth}
        // disabled={isDisabled}
        onClick={""}
        {...rest}
      />
    );
  } else {
    return <ButtonStyled fullWidth={fullWidth} {...rest} />;
  }
}

const commonStyled = css`
  ${(props) =>
    props.fullWidth &&
    css`
      width: 100%;
    `}
  height: 50px;
  line-height: 20px;
  font-size: 18px;
  border: none;
  border-radius: 1.5rem;
  cursor: pointer;
  color: #fff;
  background: #a680d2;
  &:hover {
    background: #8062a3;
  }
`;

const LinkStyled = styled.a`
  ${commonStyled}
  text-decoration: none;
  font-size: 16px;
  padding: 5px 10px;
  ${(props) =>
    props.defaultType &&
    css`
      background: #797979;
      &:hover {
        background: #424242;
      }
    `}
`;

const ButtonStyled = styled.button`
  ${commonStyled}
`;

export default AuthButton;
