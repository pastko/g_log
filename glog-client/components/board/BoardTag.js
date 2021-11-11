import styled from 'styled-components';

function BoardTag() {
    return (
        <StyledInput placeholder='태그를 입력하세요' />
    );
}

const StyledInput = styled.input`
    width: 100%;
    min-width: 8rem;
    line-height: 2rem;
    font-size: 1rem;
    color: #858585;
    display: inline-flex;
    outline: none;
    cursor: text;
    margin-bottom: 0.75rem;
    border: none;
`;

export default BoardTag;