fetch("/api/product", {
    method: 'GET'
})
    .then(res => res.json())
    .then(res => {
        console.log(res.data.products);
    }).catch(err => {
        console.log(err);
});
