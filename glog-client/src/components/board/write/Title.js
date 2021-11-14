import styled from "styled-components";

function Title({ title, setTitle }) {
  return (
    <StyledTitle
      placeholder="제목을 입력하세요."
      onChange={setTitle}
      value={title || ""}
    ></StyledTitle>
  );
}

const StyledTitle = styled.textarea`
  display: block;
  width: 100%;
  min-width: 8rem;
  height: 80%;
  resize: none;
  outline: none;
  border: none;
  line-height: 1.5;
  font-size: 1.8rem;
  font-weight: bold;
  color: #acb5bd;
`;

export default Title;
