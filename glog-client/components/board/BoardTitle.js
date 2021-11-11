import styled from "styled-components";

function BoardTitle() {
    return (
        <StyledTitle placeholder="제목을 입력하세요."></StyledTitle>
    );
}

const StyledTitle = styled.textarea`
    display: block;
    width: 100%;
    min-width: 8rem;
    height: 80%;
    font-size: 1.8rem;
    resize: none;
    line-height: 1.5;
    outline: none;
    border: none;
    font-weight: bold;
    color: #acb5bd;
`;

export default BoardTitle;