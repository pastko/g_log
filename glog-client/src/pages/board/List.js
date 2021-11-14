import styled from "styled-components";
import Card from '../../components/board/list/Card';

function List() {
    return (
        <StyledPostList>
            <Card />
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