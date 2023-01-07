import React, {FC, memo, useEffect, useState} from 'react';
import {useAppDispatch, useAppSelector} from "../../hooks/redux";
import {fetchGames} from "../../store/actions/gamesAction";
import {useNavigate} from "react-router-dom";
import Sidebar from "../Sidebar";
import {GamesFilter} from "./GamesFilter";
import {defaultFilterTitles} from "../../constants/filter";
import GameCard from "./game/GameCard";
import {Modal} from "../UI/Modal";
import {FunnelIcon} from "@heroicons/react/20/solid";
import {SkeletonGamesList} from "./SkeletonGamesList";


const GamesList: FC = memo(() => {
    const [modalVisible, setModalVisible] = useState(false)
    const {games, loading, error} = useAppSelector(state => state.games)
    const navigate = useNavigate()
    const dispatch = useAppDispatch()
    useEffect(() => {
        setTimeout(() => {
            dispatch(fetchGames(defaultFilterTitles))
        }, 2500)
    }, []);

    if (loading === "failed")
        navigate("/error")

    return (
        <section className={"w-full my-4"}>
            {games.length !== 0 &&
                <Sidebar>
                    <GamesFilter/>
                </Sidebar>
            }
            <div className={"lg:ml-64"}>
                <div className={"flex justify-between items-center mb-2"}>
                    <div>Games</div>
                    <div className={"lg:hidden"}>
                        <button className={"flex items-center cursor-pointer"} onClick={() => setModalVisible(true)}>
                            filter
                            <FunnelIcon className={"w-4 h-4 ml-1"}/>
                        </button>
                        <Modal
                            isOpen={modalVisible}
                            setIsOpen={setModalVisible}
                        >
                            <GamesFilter setModalVisible={setModalVisible}/>
                        </Modal>
                    </div>
                </div>
                <div
                    className={"flex space-x-2 w-full overflow-x-auto lg:flex-none lg:space-x-0 lg:overflow-x-visible lg:grid lg:gap-x-4 lg:grid-cols-3 lg:gap-y-4 xl:grid-cols-4"}>
                    {loading === "succeeded" && games.map(game => (
                        <GameCard
                            {...game}
                            key={game.id}
                        />
                    ))}
                    {loading !== "succeeded" && <SkeletonGamesList/>}
                </div>
            </div>
        </section>
    );
})

export default GamesList;