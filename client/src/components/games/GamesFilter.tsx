import React, {FC, Fragment, useState} from 'react';
import {Listbox} from "@headlessui/react";
import {CheckIcon, ChevronDownIcon} from "@heroicons/react/20/solid";
import Button from "../UI/Button";
import {useAppDispatch} from "../../hooks/redux";
import {fetchGames} from "../../store/actions/gamesAction";
import {fields, orders, pages, pageSizes} from "../../constants/filter";

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
            pageSize: selectedPageSize.title,
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
            <div>
                <div className={"text-sm"}>Sort by</div>
                <Listbox value={selectedField} onChange={setSelectedField}>
                    <Listbox.Button
                        className={"flex items-center justify-between bg-gray-100 py-1 px-2 rounded-lg w-full dark:bg-slate-900"}>
                        {selectedField.title}
                        <ChevronDownIcon className={"w-4 h-4"}/>
                    </Listbox.Button>
                    <Listbox.Options className={"rounded-lg overflow-hidden bg-gray-100 mt-2"}>
                        {fields.map((field) => (
                            <Listbox.Option key={field.id} value={field} as={Fragment}>
                                {({active, selected}) => (
                                    <li
                                        className={"flex items-center py-1 px-2 cursor-pointer " + `${
                                            active
                                                ? 'bg-blue-600 text-white dark:text-slate-900 dark:bg-sky-500'
                                                : 'bg-gray-100 text-black dark:bg-slate-900 dark:text-white'
                                        }`}
                                    >
                                        <div className={"w-4 h-4"}>
                                            {selected && <CheckIcon className={"w-4 h-4"}/>}
                                        </div>
                                        <div className={"ml-2"}>
                                            {field.title}
                                        </div>
                                    </li>
                                )}
                            </Listbox.Option>
                        ))}
                    </Listbox.Options>
                </Listbox>
            </div>
            <div>
                <div className={"text-sm"}>Page</div>
                <Listbox value={selectedPage} onChange={setSelectedPage}>
                    <Listbox.Button
                        className={"flex items-center justify-between bg-gray-100 py-1 px-2 rounded-lg w-full dark:bg-slate-900"}>
                        {selectedPage.title}
                        <ChevronDownIcon className={"w-4 h-4"}/>
                    </Listbox.Button>
                    <Listbox.Options className={"rounded-lg overflow-hidden bg-gray-100 mt-2"}>
                        {pages.map((field) => (
                            <Listbox.Option key={field.id} value={field} as={Fragment}>
                                {({active, selected}) => (
                                    <li
                                        className={"flex items-center py-1 px-2 cursor-pointer " + `${
                                            active
                                                ? 'bg-blue-600 text-white dark:text-slate-900 dark:bg-sky-500'
                                                : 'bg-gray-100 text-black dark:bg-slate-900 dark:text-white'
                                        }`}
                                    >
                                        <div className={"w-4 h-4"}>
                                            {selected && <CheckIcon className={"w-4 h-4"}/>}
                                        </div>
                                        <div className={"ml-2"}>
                                            {field.title}
                                        </div>
                                    </li>
                                )}
                            </Listbox.Option>
                        ))}
                    </Listbox.Options>
                </Listbox>
            </div>
            <div>
                <div className={"text-sm"}>Order</div>
                <Listbox value={selectedOrder} onChange={setSelectedOrder}>
                    <Listbox.Button
                        className={"flex items-center justify-between bg-gray-100 py-1 px-2 rounded-lg w-full dark:bg-slate-900"}>
                        {selectedOrder.title}
                        <ChevronDownIcon className={"w-4 h-4"}/>
                    </Listbox.Button>
                    <Listbox.Options className={"rounded-lg overflow-hidden bg-gray-100 mt-2"}>
                        {orders.map((order) => (
                            <Listbox.Option key={order.id} value={order} as={Fragment}>
                                {({active, selected}) => (
                                    <li
                                        className={"flex items-center py-1 px-2 cursor-pointer " + `${
                                            active
                                                ? 'bg-blue-600 text-white dark:text-slate-900 dark:bg-sky-500'
                                                : 'bg-gray-100 text-black dark:bg-slate-900 dark:text-white'
                                        }`}
                                    >
                                        <div className={"w-4 h-4"}>
                                            {selected && <CheckIcon className={"w-4 h-4"}/>}
                                        </div>
                                        <div className={"ml-2"}>
                                            {order.title}
                                        </div>
                                    </li>
                                )}
                            </Listbox.Option>
                        ))}
                    </Listbox.Options>
                </Listbox>
            </div>
            <div>
                <div className={"text-sm"}>Page size</div>
                <Listbox value={selectedPageSize} onChange={setSelectedPageSize}>
                    <Listbox.Button
                        className={"flex items-center justify-between bg-gray-100 py-1 px-2 rounded-lg w-full dark:bg-slate-900"}>
                        {selectedPageSize.title}
                        <ChevronDownIcon className={"w-4 h-4"}/>
                    </Listbox.Button>
                    <Listbox.Options className={"rounded-lg overflow-hidden bg-gray-100 mt-2"}>
                        {pageSizes.map((pageSize) => (
                            <Listbox.Option key={pageSize.id} value={pageSize} as={Fragment}>
                                {({active, selected}) => (
                                    <li
                                        className={"flex items-center py-1 px-2 cursor-pointer " + `${
                                            active
                                                ? 'bg-blue-600 text-white dark:text-slate-900 dark:bg-sky-500'
                                                : 'bg-gray-100 text-black dark:bg-slate-900 dark:text-white'
                                        }`}
                                    >
                                        <div className={"w-4 h-4"}>
                                            {selected && <CheckIcon className={"w-4 h-4"}/>}
                                        </div>
                                        <div className={"ml-2"}>
                                            {pageSize.title}
                                        </div>
                                    </li>
                                )}
                            </Listbox.Option>
                        ))}
                    </Listbox.Options>
                </Listbox>
            </div>
            <Button
                className={"text-white bg-blue-600 dark:bg-sky-400 dark:text-slate-800"}
                onClick={filterHandler}>
                Apply filters
            </Button>
        </div>
    );
}