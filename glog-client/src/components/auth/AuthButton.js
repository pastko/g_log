import styled, { css } from "styled-components";

function AuthButton({ isLink, defaultType, fullWidth, _onClick, ...rest }) {

  if (isLink) {
    return <LinkStyled defaultType={defaultType} {...rest} />;
  }
  return (
    <>
      <ButtonStyled
        type="button"
        fullWidth={fullWidth}
        onClick={_onClick}
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
