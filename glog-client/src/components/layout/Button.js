import styled, {css} from "styled-components";

function Button({isDefault, children, _onClick, ...rest }) {
    return (
        <StyledButton isDefault={isDefault} {...rest} onClick={_onClick}>
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
    ${(props) =>
        props.isDefault &&
        css`
            background-color: #9b9b9b;
    `}
`;

export default Button;