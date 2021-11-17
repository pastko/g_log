import styled, { css } from "styled-components";

function Button({ isRed, isDefault, isNone, isLink, children, fullwidth, _onClick, ...rest }) {
    const style = {
        isRed,
        isDefault,
        isNone
    }
    if (isLink) {
        return (
            <StyledLink {...style} onClick={_onClick}>
                {children}
            </StyledLink>
        )
    }
    return (
        <StyledButton
            {...style}
            fullwidth={fullwidth}
            {...rest}
            onClick={_onClick}
        >
            {children}
        </StyledButton>
    )
}

const commStyle = css`
    display: flex;
    align-items: center;
    justify-items: center;
    background-color: #a680d2;
    height: 30px;
    border-radius: 0.3rem;
    border: none;
    padding: 20px 20px;
    box-sizing: border-box;
    font-size: 16px;
    font-weight: 700;
    color: #fff;
    cursor: pointer;
    ${(props) =>
        props.isDefault &&
        css`
            font-weight: 800;
            background-color: #f8f9fa;
            color: #a680d2;
            border: 2px solid #a680d2;
            border-radius: 3rem;
    `}
    ${(props) =>
        props.isRed &&
        css`
            background-color: rgb(255, 107, 107);
            color: #fff;
    `}
    ${(props) =>
        props.isNone &&
        css`
            border: 0;
    `}
    ${(props) =>
        props.fullwidth &&
        css`
            width: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
            margin-top: 0.5rem;
    `}
    
`;

const StyledLink = styled.a`
    ${commStyle}
    display: inline-block;
    line-height: 0.2;
   
`;

const StyledButton = styled.button`
    ${commStyle}
`;

export default Button;