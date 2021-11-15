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
            <Card
                path="/post/2.png"
                open={true}
                preview="velopert님의 영상을 토대로 정리한 블로그 글입니다.
동영상으로 보실분들은 velopert님의 유튜브 영상을 시청해주세요!"
            />
            <Card
                path="/post/3.png"
                open={true}
                preview="오늘은 문제를 풀며 레퍼런스와 다르게 풀었던 문제들을 정리해서 블로깅 하려한다!
                let 문제 = 인생;
                let 레퍼런스 = 조언;
                let 나의문제풀이 = 내선택;"
            />
            <Card
                path="/post/4.png"
                open={true}
                preview="무엇 인가를 배우는 과정이 그 열정에 비해 더욱더 어렵다면 무너지기 마련이다. 그럴 땐 무너지기 보다는 그 배움에 대한 열정을 늘리는 것 또한 방법이지 않을까? 요즘은 이 생각으로 하루를 버티며 나아간다.
            많은 선배 개발자들에게 깊은 존경을 표하며 글을 시작하려 한다.
            그리고 또한 같은 상황의 이제 막 개발을 시작한 우리 새싹 개발자들에게도 응원을 보내며 다같이 얼굴이 반쪽이 되더라도 포기하지 않길 바라며 시작해 보겠다."
            />
            <Card
                path="/post/5.png"
                open={false}
                preview="velopert님의 영상을 토대로 정리한 블로그 글입니다.
            동영상으로 보실분들은 velopert님의 유튜브 영상을 시청해주세요!"
            />
            <Card
                path="/post/6.png"
                open={true}
                preview="velopert님의 영상을 토대로 정리한 블로그 글입니다.
            동영상으로 보실분들은 velopert님의 유튜브 영상을 시청해주세요!"
            />
            <Card
                path="/post/1.png"
                open={true}
                preview="velopert님의 영상을 토대로 정리한 블로그 글입니다.
            동영상으로 보실분들은 velopert님의 유튜브 영상을 시청해주세요!"
            />
            <Card
                path="/post/2.png"
                open={true}
                preview="velopert님의 영상을 토대로 정리한 블로그 글입니다.
            동영상으로 보실분들은 velopert님의 유튜브 영상을 시청해주세요!"
            />
            <Card
                path="/post/3.png"
                open={false}
                preview="velopert님의 영상을 토대로 정리한 블로그 글입니다.
            동영상으로 보실분들은 velopert님의 유튜브 영상을 시청해주세요!"
            />
            <Card
                path="/post/4.png"
                open={true}
                preview="velopert님의 영상을 토대로 정리한 블로그 글입니다.
            동영상으로 보실분들은 velopert님의 유튜브 영상을 시청해주세요!"
            />
            <Card
                path="/post/5.png"
                open={true}
                preview="velopert님의 영상을 토대로 정리한 블로그 글입니다.
            동영상으로 보실분들은 velopert님의 유튜브 영상을 시청해주세요!"
            />
            <Card
                path="/post/6.png"
                open={true}
                preview="velopert님의 영상을 토대로 정리한 블로그 글입니다.
            동영상으로 보실분들은 velopert님의 유튜브 영상을 시청해주세요!"
            />
            <Card
                path="/post/1.png"
                open={true}
                preview="velopert님의 영상을 토대로 정리한 블로그 글입니다.
            동영상으로 보실분들은 velopert님의 유튜브 영상을 시청해주세요!"
            />
            <Card
                path="/post/2.png"
                open={false}
                preview="velopert님의 영상을 토대로 정리한 블로그 글입니다.
            동영상으로 보실분들은 velopert님의 유튜브 영상을 시청해주세요!"
            />
            <Card
                path="/post/3.png"
                open={true}
                preview="velopert님의 영상을 토대로 정리한 블로그 글입니다.
            동영상으로 보실분들은 velopert님의 유튜브 영상을 시청해주세요!"
            />
            <Card
                path="/post/4.png"
                open={false}
                preview="velopert님의 영상을 토대로 정리한 블로그 글입니다.
            동영상으로 보실분들은 velopert님의 유튜브 영상을 시청해주세요!"
            />
            <Card
                path="/post/5.png"
                open={true}
                preview="velopert님의 영상을 토대로 정리한 블로그 글입니다.
            동영상으로 보실분들은 velopert님의 유튜브 영상을 시청해주세요!"
            />
            <Card
                path="/post/6.png"
                open={true}
                preview="velopert님의 영상을 토대로 정리한 블로그 글입니다.
            동영상으로 보실분들은 velopert님의 유튜브 영상을 시청해주세요!"
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