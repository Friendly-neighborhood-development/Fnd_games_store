import React from 'react';
import MainLayout from "../components/layouts/MainLayout";
import {useParams} from "react-router-dom";

const GameName = () => {
    const {name} = useParams()
    return (
        <MainLayout>
            {name}
        </MainLayout>
    );
};

export default GameName;