export const fields = [
    {id: 1, title: 'name'},
    {id: 2, title: 'discount'},
    {id: 3, title: 'releaseDate'},
    {id: 4, title: 'platform'},
    {id: 5, title: 'price'},
]

export const pages = [
    {id: 1, title: "1"},
    {id: 2, title: "2"},
    {id: 3, title: "3"},
    {id: 4, title: "4"},
    {id: 5, title: "5"},
]

export const orders = [
    {id: 1, title: "direct"},
    {id: 2, title: "reverse"},
]

export const pageSizes = [
    {id: 1, title: "5"},
    {id: 2, title: "10"},
    {id: 3, title: "20"},
]

const defaultFilter = {
    page: pages[0],
    pageSize: pageSizes[1],
    sortField: fields[0],
    ascOrder: orders[0]
}

export const defaultFilterTitles={
    page: +pages[0].title - 1,
    pageSize: +pageSizes[1].title,
    sortField: fields[0].title,
    ascOrder: orders[0].title === "direct"
}