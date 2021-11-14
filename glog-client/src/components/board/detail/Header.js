import styled from "styled-components";

function Header() {
    return (
        <StyledHeader>
            <StyledTitle>test</StyledTitle>
        </StyledHeader>
    );
}
const StyledHeader = styled.header`
    width: 100vw;
    max-width: 768px;
    box-sizing: border-box;
    justify-content: space-between;
`;
const StyledTitle = styled.h1`
`;


export default Header;