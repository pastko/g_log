import styled from "styled-components";
import Card from '../../components/board/list/Card';
import UserInfo from '../../components/board/element/UserInfo';

function List() {
    return (
        <StyledPostList>
            <UserInfo />
            <Card
                url="/post/detail"
                path="/post/1.png"
                open={true}
                preview="안녕하세요. test입니다."
            />
        </StyledPostList>
    );
}

const StyledPostList = styled.div`
     @media (max-width: 1440px) {
        width: 1280px
    }
    @media (max-width: 1280px) {
        width: 768px;
    }
    @media (max-width: 768px) {
        width: 100%;
    }
    max-width: 1280px;
    margin: 0 auto;
    
`;

export default List;