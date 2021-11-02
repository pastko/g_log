import { FaGoogle, FaGithub } from 'react-icons/fa';
import styled from 'styled-components';

function SocialButton({btnType}) {
  return (
      <StyledSocial>
        {(btnType === "Google") ? <FaGoogle/> : <FaGithub/>}
        <span>{btnType}계정으로 계속하기</span>
    </StyledSocial>
  );
}
const StyledSocial = styled.button`
    width: 100%;
    height: 40px;
    margin-top: 10px;
    line-height: 18px;
    font-size: 16px;
    border: 2px solid #ddd;
    border-radius: 1.5rem;
    cursor: pointer;
    background: #fff;
    color: #797979;
    span {
        display: inline-block;
        margin-left: 10px;
    }
    &:hover {
        border: 1px solid #a680d2;
        background-color: #a680d267;
        color: #fff;
    }

`;
export default SocialButton;