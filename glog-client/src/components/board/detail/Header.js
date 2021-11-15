import styled from "styled-components";
import Tag from "../element/Tag";

function Header() {
    return (
        <StyledHeader>
            <StyledTitle>test 입니다.test 입니다.test 입니다.test 입니다.test 입니다.</StyledTitle>
            <StyledSubInfo>
                <span className="author">작성자</span>
                <div className='separator'>·</div>
                <span>2021년 10월 26일</span>
            </StyledSubInfo>
            <StyledTagWrap>
                <Tag children='test' />
                <Tag children='test' />
            </StyledTagWrap>
        </StyledHeader>
    );
}
const StyledHeader = styled.header`
    width: 100vw;
    max-width: 768px;
    box-sizing: border-box;
    justify-content: space-between;
    text-align: left;
`;
const StyledTitle = styled.h1`
    font-size: 3rem;
    line-height: 1.5;
    letter-spacing: -0.004em;
    margin: 0 0 2rem;
    font-weight: 800;
    color: rgb(52, 58, 64);
    word-break: keep-all;
`;

const StyledSubInfo = styled.div`
    display: flex;
    align-items: center;
    font-size: 1.05rem;
    color: #2e2e2e;
    line-height: 1.3;
    margin: 0 0 0.8rem;
    .author {
        font-weight: 600;
    }
    .separator {
        margin: 0 0.5rem;
    }
`;

const StyledTagWrap = styled.div`
    display: flex;
    align-items: center;
    margin-left: -5px;
`;

export default Header;