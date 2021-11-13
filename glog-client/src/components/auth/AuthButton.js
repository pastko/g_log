import { useState } from "react";
import styled, { css } from "styled-components";
import { actionCreators as userActions } from '../../store/reducer/users';
import { history } from '../../store/configureStore';
import { useDispatch } from 'react-redux';
//import ErrorMessage from '../layout/ErrorMessage';

function AuthButton({ isLink, defaultType, fullWidth, isForm, ...rest }) {
  const dispatch = useDispatch();

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
  const goAction = () => {
      if(isForm.confirmPwd === "" && isForm.nikNm === ""){
        console.log("sign In");
        dispatch(userActions.signinAPI(isForm.mail, isForm.pwd));
      }else{
        console.log("sign Up");
        dispatch(userActions.signupAPI(isForm.mail,isForm.pwd ,isForm.nikNm));
      }
  };

  if (isLink) {
    return <LinkStyled defaultType={defaultType} {...rest} />;
  }
  // if (validate()) {
  return (
    <>
      <ButtonStyled 
        type="button"
        fullWidth={fullWidth}
        disabled={isDisabled}
        onClick={goAction}
        {...rest}
      />
    </>
  );
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
