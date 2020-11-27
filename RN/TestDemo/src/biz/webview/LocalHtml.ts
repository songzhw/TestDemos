export const html = `
<!DOCTYPE html>
<html lang="en">
<head>
  <script>
    function changeText() {
      var h1 = document.getElementById("title");
      h1.innerHTML = "second";
    }
  </script>
</head>
<body>
<h1 id="title">Hello World</h1>
</body>
</html>
`;
