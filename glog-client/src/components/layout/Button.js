import styled, { css } from "styled-components";

function Button({ isRed, isDefault, children, fullwidth, _onClick, ...rest }) {
    return (
        <StyledButton
            isRed={isRed}
            isDefault={isDefault}
            fullwidth={fullwidth}
            {...rest}
            onClick={_onClick}
        >
            {children}
        </StyledButton>
    );
}

const StyledButton = styled.button`
    height: 30px;
    border-radius: 0.3rem;
    border: none;
    padding: 20px 20px;
    background-color: #a680d2;
    color: #fff;
    display: flex;
    align-items: center;
    justify-items: center;
    font-size: 16px;
    cursor: pointer;
    font-weight: 700;
    ${(props) =>
        props.isDefault &&
        css`
            background-color: #f8f9fa;
            color: #a680d2;
    `}
    ${(props) =>
        props.isRed &&
        css`
            background-color: rgb(255, 107, 107);
            color: #fff;
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

export default Button;