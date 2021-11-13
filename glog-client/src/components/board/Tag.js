import styled from "styled-components";

function Tag({idx, removeTag, children}) {

    return (
      <StyledTag onClick={removeTag}>
        {children}
      </StyledTag>
    );
}

const StyledTag = styled.div`
    display: flex;
    align-items: center;
    justify-items: center;
    color: #fff;
    background-color: #a680d2;
    cursor: pointer;
    padding: 0 0.75rem 0.2rem;
    border-radius: 1rem;
    margin-left: 0.3rem;
    margin-right: 0.5rem;
    line-height: 1.5rem;
    font-size: 1rem;
`;

export default Tag;