import React, {FC, Fragment, useState} from 'react';
import {Listbox} from "@headlessui/react";
import {CheckIcon, ChevronDownIcon} from "@heroicons/react/20/solid";
import Button from "../UI/Button";
import {useAppDispatch} from "../../hooks/redux";
import {fetchGames} from "../../store/actions/gamesAction";
import {fields, orders, pages, pageSizes} from "../../constants/filter";
import {GamesFilterField} from "./GamesFilterField";

interface GamesFilterProps{
    setModalVisible?:(visible: boolean) => void
}

export const GamesFilter: FC<GamesFilterProps> = ({setModalVisible}) => {
    const dispatch = useAppDispatch()
    const [selectedField, setSelectedField] = useState(fields[0])
    const [selectedPage, setSelectedPage] = useState(pages[0])
    const [selectedOrder, setSelectedOrder] = useState(orders[0])
    const [selectedPageSize, setSelectedPageSize] = useState(pageSizes[1])

    const filterHandler = () => {
        dispatch(fetchGames({
            page: +selectedPage.title - 1,
            pageSize: +selectedPageSize.title,
            sortField: selectedField.title,
            ascOrder: selectedOrder.title === "direct"
        }))
        if (setModalVisible) {
            setModalVisible(false)
        }

    }
    const resetFilter = () => {
        setSelectedField(fields[0])
        setSelectedPage(pages[0])
        setSelectedOrder(orders[0])
        setSelectedPageSize(pageSizes[1])
    }
    return (
        <div className={"flex flex-col space-y-4"}>
            <div className={"flex justify-between"}>
                <div>Filter</div>
                <div onClick={resetFilter} className={"cursor-pointer"}>Reset</div>
            </div>
            <GamesFilterField title={"Sort by"} selectedValue={selectedField} setSelectedValue={setSelectedField} values={fields}/>
            <GamesFilterField title={"Page"} selectedValue={selectedPage} setSelectedValue={setSelectedPage} values={pages}/>
            <GamesFilterField title={"Order"} selectedValue={selectedOrder} setSelectedValue={setSelectedOrder} values={orders}/>
            <GamesFilterField title={"Page size"} selectedValue={selectedPageSize} setSelectedValue={setSelectedPageSize} values={pageSizes}/>
            <Button
                className={"text-white bg-blue-600 dark:bg-sky-400 dark:text-slate-800"}
                onClick={filterHandler}>
                Apply filters
            </Button>
        </div>
    );
}
